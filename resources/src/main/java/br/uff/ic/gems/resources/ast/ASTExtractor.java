/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.resources.ast;

import br.uff.ic.gems.resources.data.LanguageConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 *
 * @author gleiph
 */
public class ASTExtractor {

    String filePath;
    List<LanguageConstruct> languageConstructs;

    public ASTExtractor(String filePath) {
        this.filePath = filePath;
    }

    public ASTExtractor() {
    }

    //It starts the analysis
    public void parser() throws IOException {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        File file = new File(filePath);

        String stringFile = FileUtils.readFileToString(file);
        parser.setSource(stringFile.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        //Setting options
        Map options;
        options = JavaCore.getOptions();
        options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7);
        options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
        options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
        parser.setCompilerOptions(options);
        
        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        Visitor visitor = new Visitor(cu);
        cu.accept(visitor);

        List<Comment> commentList = cu.getCommentList();

        for (Comment comment : commentList) {
            comment.accept(visitor);
        }

        languageConstructs = visitor.getLanguageConstructs();

    }

    public List<LanguageConstruct> getLanguageConstructs(int begin, int end) {
        List<LanguageConstruct> lcs = LanguageConstruct.getLanguageConstructs(begin, end, languageConstructs);
        
        List<LanguageConstruct> result = new ArrayList<>();
        
        for (LanguageConstruct lc : lcs) {
            result.add(lc.clone());
        }
        
        return result;
    }

    public String toString(List<String> input) {

        String result = "";
        
        if(input.isEmpty())
            return null;
        
        for (int i = 0; i < input.size() - 1; i++) {
            result += input.get(i) + ", ";
        }

        result += input.get(input.size() - 1);

        return result;
    }
}
