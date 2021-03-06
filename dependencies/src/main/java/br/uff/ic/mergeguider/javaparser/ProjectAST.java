/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.mergeguider.javaparser;


import br.uff.ic.mergeguider.languageConstructs.MyMethodInvocation;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;

/**
 *
 * @author gleiph
 */
public class ProjectAST {

    private String projectPath;
    private List<ClassLanguageContructs> classesLanguageConstructs;

    public ProjectAST(String projectPath) {
        this.projectPath = projectPath;
        JavaParser javaParser = new JavaParser();
        classesLanguageConstructs = javaParser.parser(projectPath);
    }

    public List<MyMethodInvocation> getMethodCallers(MethodDeclaration methodDeclaration) {
        List<MyMethodInvocation> invocations = new ArrayList<>();

        IMethodBinding methodDeclarationBinding = methodDeclaration.resolveBinding();
        if (methodDeclarationBinding == null) {
            //Method does not have binding
            return null;
        }

        for (ClassLanguageContructs languageConstructsByClass : classesLanguageConstructs) {
            for (MyMethodInvocation methoInvocation : languageConstructsByClass.getMethodInvocations()) {

                IMethodBinding methodInvocationBinding = methoInvocation.getMethodInvocation().resolveMethodBinding();

                if (methodInvocationBinding == null) {
                    //no binding
                    continue;
                }

                if (methodDeclarationBinding.equals(methodInvocationBinding)) {
                    invocations.add(methoInvocation);
                }
            }
        }

        return invocations;
    }

    
    
    /**
     * @return the projectPath
     */
    public String getProjectPath() {
        return projectPath;
    }

    /**
     * @param projectPath the projectPath to set
     */
    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    /**
     * @return the classesLanguageConstructs
     */
    public List<ClassLanguageContructs> getClassesLanguageConstructs() {
        return classesLanguageConstructs;
    }

    /**
     * @param languageConstructsByClasses the classesLanguageConstructs to set
     */
    public void setClassesLanguageConstructs(List<ClassLanguageContructs> languageConstructsByClasses) {
        this.classesLanguageConstructs = languageConstructsByClasses;
    }
}
