/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.resources.ast;

import br.uff.ic.gems.resources.data.ConflictingChunk;
import br.uff.ic.gems.resources.data.LanguageConstruct;
import br.uff.ic.gems.resources.utils.Context;
import br.uff.ic.gems.resources.utils.ContextFinder;
import br.uff.ic.gems.resources.vcs.Git;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author gleiph
 */
public class ASTAuxiliar {
    
    public static void cloneRepositories(String sourceRepository, String leftRepository, String rightRepository, String developerMergeRepositoryPath) {
        if (!new File(developerMergeRepositoryPath).isDirectory()) {
            System.out.println("Cloning Developer merge repository...");
            Git.clone(sourceRepository, sourceRepository, developerMergeRepositoryPath);
        }
        
        if (!new File(leftRepository).isDirectory()) {
            System.out.println("Cloning left reporitory...");
            Git.clone(sourceRepository, sourceRepository, leftRepository);
        }
        if (!new File(rightRepository).isDirectory()) {
            System.out.println("Cloning rifht repository...");
            Git.clone(sourceRepository, sourceRepository, rightRepository);
        }
    }
    
//    public static int getConflictUpperBound(ConflictingChunk conflictArea, int context, List<String> fileConflict) {
//        int conflictingUpperBound;
//        conflictingUpperBound = conflictArea.getEnd() + context;
//        if (conflictingUpperBound > fileConflict.size()) {
//            conflictingUpperBound = fileConflict.size();
//        }
//        return conflictingUpperBound;
//    }
//
//    public static int getConflictLowerBound(ConflictingChunk conflictArea, int context) {
//        int conflictLowerBound;
//        conflictLowerBound = conflictArea.getBegin() - context;
//        if (conflictLowerBound < 0) {
//            conflictLowerBound = 0;
//        }
//        return conflictLowerBound;
//    }
    
    public static int getConflictUpperBound(ConflictingChunk conflictArea, int context, List<String> fileConflict) {
        int conflictingUpperBound;
        conflictingUpperBound = conflictArea.getEndLine()+ context + 1;////I don't want do exclude the last line
        if (conflictingUpperBound > fileConflict.size()) {
            conflictingUpperBound = fileConflict.size();
        }
        return conflictingUpperBound;
    }

    public static int getConflictLowerBound(ConflictingChunk conflictArea, int context) {
        int conflictLowerBound;
        conflictLowerBound = conflictArea.getBeginLine()- context;
        if (conflictLowerBound < 0) {
            conflictLowerBound = 0;
        }
        return conflictLowerBound;
    }
    
    public static List<LanguageConstruct> getSyntacticStructures(List<String> conflictArea, String repository, String relativePath) throws IOException {
        //Left side
        List<String> conflict = conflictArea;
        String file = repository + relativePath;
        List<String> fileList = FileUtils.readLines(new File(file));
        List<Integer> beginList = new ArrayList<>();
        
        for (Context b : ContextFinder.getBegin(conflict, fileList)) {
            beginList.add(b.getLineNumber());
        }
        
        int begin = 0;
        if (beginList.size() == 1) {
            begin = beginList.get(0) + 1;//transform in the real line (begining from 1)
        }
        int end = begin + conflict.size() - 1;
        //Dealing with AST
        ASTExtractor ats = new ASTExtractor(file);
        ats.parser();
        List<LanguageConstruct> kindConflict = ats.getLanguageConstructs(begin, end);

        return kindConflict;
    }

}