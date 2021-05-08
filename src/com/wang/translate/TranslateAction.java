package com.wang.translate;

import com.google.gson.Gson;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.PairFunction;
import com.wang.utils.HttpUtils;
import com.wang.utils.StringUtils;
import org.apache.http.util.TextUtils;
import org.jetbrains.annotations.NotNull;

/**
 * @author wangjc
 * date: 2021-05-08
 * description:生成
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
            if (!TextUtils.isEmpty(translateResult)) {
                Messages.showDialog(project,StringUtils.captureStringLeaveUnderscore(translateResult),"Translate Result", new String[]{"OK"},0,null);
            }
//        Messages.showCheckboxMessageDialog(translateResult
//                ,translateResult
//        ,new String[]{"choose one","two","for"}
//        ,""
//        ,false
//        ,0
//        ,0
//                ,null
//        ,(exitCode, cb) -> {
//                    return exitCode == -1 ? 2 : exitCode + (cb.isSelected() ? 1 : 0);
//                });
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
