/* $Id$ */
package ru.naumen.nauchat.server.hibernate.entity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.IOUtils;
import org.hibernate.annotations.Type;

/**
 * Позволяет хранить загруженные файлы на сервере БД. Это необходимо в
 * кластерной конфигурации когда файл может быть загружен на один нод кластера,
 * а бизнес операция его использующая выполняться на другом ноде.
 * 
 * @author nshestakov
 * 
 */
@Entity
@Table(name = "tbl_sys_uploaded")
//Не кешируем, потому что есть Blob поле
public class DBFileItem implements FileItem
{
    private static final long serialVersionUID = -4611456544125136423L;
    @Id
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "file_content")
    @Type(type = "ru.naumen.core.server.hibernate.BlobType")
    private Blob content;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "name")
    private String name;
    @Column(name = "file_size")
    private long size;
    @Column(name = "field_name")
    private String fieldName;
    @Column(name = "form_field")
    private boolean formField;
    @Column(name = "upload_date")
    private Date date = new Date();

    transient private byte[] bytes;

    @Override
    public void delete()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] get()
    {
        if (null == bytes)
        {
            try (InputStream inputStream = getInputStream())
            {
                bytes = IOUtils.toByteArray(inputStream);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return bytes;
    }

    public Blob getContent()
    {
        return content;
    }

    @Override
    public String getContentType()
    {
        return contentType;
    }

    public Date getDate()
    {
        return date;
    }

    @Override
    public String getFieldName()
    {
        return fieldName;
    }

    @Override
    public InputStream getInputStream() throws IOException
    {
        return getStream();
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public OutputStream getOutputStream() throws IOException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getSize()
    {
        return size;
    }

    public InputStream getStream()
    {
        try
        {
            return content.getBinaryStream();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getString()
    {
        return new String(get(), Charset.forName("UTF-8"));
    }

    @Override
    public String getString(String encoding) throws UnsupportedEncodingException
    {
        return new String(get(), encoding);
    }

    public String getUuid()
    {
        return uuid;
    }

    @Override
    public boolean isFormField()
    {
        return formField;
    }

    @Override
    public boolean isInMemory()
    {
        return false;
    }

    public void setContent(Blob content)
    {
        this.content = content;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @Override
    public void setFieldName(String name)
    {
        fieldName = name;
    }

    @Override
    public void setFormField(boolean state)
    {
        formField = state;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    @Override
    public void write(File file) throws Exception
    {
        throw new UnsupportedOperationException();
    }
}
