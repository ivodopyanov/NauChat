/* $Id$ */
package ru.naumne.nauchat.shared.upload;

import ru.naumen.nauchat.server.upload.UploadServlet;

/**
 * Константы используемый в {@link UploadServlet}
 * 
 * @author nshestakov
 * 
 */
public class UploadConstants
{
    /**
     * Имя параметра запроса в котором передается информация о идентификаторе
     * ранее загруженного файла
     */
    public static final String UPLOADED_UUID = "uploadedUuid";

    /**
     * Имя параметра запроса в котором передается загружаемый файл
     */
    public static final String FILE = "file";

    /**
     * Строка с которой начинается идентификатор загруженного файла
     */
    public static final String START_DELIMITER = "${";

    /**
     * Строка которой оканчивается идентификатор загруженного файла
     */
    public static final String END_DELIMITER = "}";

}
