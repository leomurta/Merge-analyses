/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.resources.ast;

import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

/**
 *
 * @author gleiph
 */
public class ASTTranslator {

    private static final String CLASS = "Class";
    private static final String INTERFACE = "Interface";

    public static String translate(String name) {

        if (name.equals(AnnotationTypeMemberDeclaration.class.getSimpleName())) {
            return ASTTypes.ANNOTATION_TYPE_MEMBER_DECLARATION;
        } else if (name.equals(AnonymousClassDeclaration.class.getSimpleName())
                || name.equals(TypeDeclaration.class.getSimpleName() + CLASS)) {
            return ASTTypes.CLASS_DECLARATION;
        } else if (name.equals(ArrayAccess.class.getSimpleName())) {
            return ASTTypes.ARRAY_ACCESS;
        } else if (name.equals(ArrayCreation.class.getSimpleName())
                || name.equals(ClassInstanceCreation.class.getSimpleName())
                || name.equals(ConstructorInvocation.class.getSimpleName())
                || name.equals(MethodInvocation.class.getSimpleName())
                || name.equals(SuperConstructorInvocation.class.getSimpleName())
                || name.equals(SuperMethodInvocation.class.getSimpleName())) {
            return ASTTypes.METHOD_INVOCATION;
        } else if (name.equals(ArrayInitializer.class.getSimpleName())) {
            return ASTTypes.ARRAY_INITIALIZER;
        } else if (name.equals(AssertStatement.class.getSimpleName())) {
            return ASTTypes.ASSERT_STATEMENT;
        } else if (name.equals(BlockComment.class.getSimpleName())
                || name.equals(Comment.class.getSimpleName())
                || name.equals(Javadoc.class.getSimpleName())
                || name.equals(LineComment.class.getSimpleName())) {
            return ASTTypes.COMMENT;
        } else if (name.equals(BreakStatement.class.getSimpleName())) {
            return ASTTypes.BREAK_STATEMENT;
        } else if (name.equals(CastExpression.class.getSimpleName())) {
            return ASTTypes.CAST_EXPRESSION;
        } else if (name.equals(CatchClause.class.getSimpleName())) {
            return ASTTypes.CATCH_CLAUSE;
        } else if (name.equals(ContinueStatement.class.getSimpleName())) {
            return ASTTypes.CONTINUE_STATEMENT;
        } else if (name.equals(DoStatement.class.getSimpleName())) {
            return ASTTypes.DO_STATEMENT;
        } else if (name.equals(EnhancedForStatement.class.getSimpleName())
                || name.equals(ForStatement.class.getSimpleName())) {
            return ASTTypes.FOR_STATEMENT;
        } else if (name.equals(EnumConstantDeclaration.class.getSimpleName())) {
            return ASTTypes.ENUM_VALUE;
        } else if (name.equals(EnumDeclaration.class.getSimpleName())) {
            return ASTTypes.ENUM_DECLARATION;
        } else if (name.equals(FieldDeclaration.class.getSimpleName())) {
            return ASTTypes.ATTRIBUTE;
        } else if (name.equals(IfStatement.class.getSimpleName())) {
            return ASTTypes.IF_STATEMENT;
        } else if (name.equals(ImportDeclaration.class.getSimpleName())) {
            return ASTTypes.IMPORT_DECLARATION;
        } else if (name.equals(Initializer.class.getSimpleName())) {
            return ASTTypes.STATIC_INITIALIZER;
        } else if (name.equals(MarkerAnnotation.class.getSimpleName())
                || name.equals(NormalAnnotation.class.getSimpleName())
                || name.equals(SingleMemberAnnotation.class.getSimpleName())) {
            return ASTTypes.ANNOTATION;
        } else if (name.equals(MethodDeclaration.class.getSimpleName())) {
            return ASTTypes.METHOD_DECLARATION;
        } else if (name.equals(PackageDeclaration.class.getSimpleName())) {
            return ASTTypes.PACKAGE_DECLARATION;
        } else if (name.equals(ReturnStatement.class.getSimpleName())) {
            return ASTTypes.RETURN_STATEMENT;
        } else if (name.equals(SingleVariableDeclaration.class.getSimpleName())
                || name.equals(VariableDeclarationExpression.class.getSimpleName())
                || name.equals(VariableDeclarationStatement.class.getSimpleName())) {
            return ASTTypes.VARIABLE;
        } else if (name.equals(SwitchCase.class.getSimpleName())) {
            return ASTTypes.SWITCH_STATEMENT;
        } else if (name.equals(SynchronizedStatement.class.getSimpleName())) {
            return ASTTypes.SYNCHRONIZED_STATEMENT;
        } else if (name.equals(ThrowStatement.class.getSimpleName())) {
            return ASTTypes.THROW_STATEMENT;
        } else if (name.equals(TryStatement.class.getSimpleName())) {
            return ASTTypes.TRY_STATEMENT;
        } else if (name.equals(TypeDeclaration.class.getSimpleName() + INTERFACE)) {
            return ASTTypes.INTERFACE_DECLARATION;
        } else if (name.equals(WhileStatement.class.getSimpleName())) {
            return ASTTypes.WHILE_STATEMENT;
        }

        return name;

    }

}