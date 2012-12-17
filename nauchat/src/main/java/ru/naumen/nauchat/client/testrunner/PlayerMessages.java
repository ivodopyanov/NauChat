/**
 * 
 */
package ru.naumen.nauchat.client.testrunner;

import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.Messages;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
@DefaultLocale("ru")
public interface PlayerMessages extends Messages
{
    @DefaultMessage("Загрузка файла завершена")
    String fileUploadComplete();

    @DefaultMessage("Файл не выбран!")
    String noFileSelected();

    @DefaultMessage("Выбрать файл")
    String selectFile();

    @DefaultMessage("Загрузить решение")
    String uploadSolution();
}