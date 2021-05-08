package com.wang.translate;

import com.google.gson.Gson;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.wang.utils.HttpUtils;
import org.jetbrains.annotations.NotNull;

/**
 * @author wangjc
 * date: 2021-05-08
 * description:
 */
public class TranslateAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();

        String response  = HttpUtils.doGet("http://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i="+selectedText);
        System.out.println(response);
        TranslateResult result = new Gson().fromJson(response,TranslateResult.class);
        if (result.getErrorCode() == 0){
            String translateResult = result.getTranslateResult().get(0).get(0).getTgt();
                    Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
        Messages.showInfoMessage(project,translateResult,translateResult);
//            WriteCommandAction.runWriteCommandAction(anActionEvent.getProject(), new Runnable() {
//                @Override
//                public void run() {
//                    PsiFile psiFile = anActionEvent.getData(LangDataKeys.PSI_FILE);
//                    PsiElement element = psiFile.findElementAt(editor.getCaretModel().getOffset());
//                    PsiClass psiClass = PsiTreeUtil.getParentOfType(element, PsiClass.class);
//                    PsiElementFactory elementFactory = JavaPsiFacade.getElementFactory(anActionEvent.getProject());
//                    String className = psiClass.getNameIdentifier().getText();
//                    String methodText = translateResult;
//                    PsiType psiType = PsiType.getTypeByName(className, anActionEvent.getProject()
//                            , GlobalSearchScope.EMPTY_SCOPE);
//                    PsiField  psiField = elementFactory.createField(methodText, psiType);
//                    psiClass.add(psiField);
//                }
//            });

        }
    }
}
