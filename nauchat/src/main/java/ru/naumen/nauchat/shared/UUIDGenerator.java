/* $Id$ */
package ru.naumen.nauchat.shared;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Random;

/**
 * Генератор случайных uuid доступный для gwt
 * 
 * @author nshestakov
 * 
 */
public class UUIDGenerator
{
    private static final UUIDGenerator INSTANCE = new UUIDGenerator();
    private static final String ZEROS = "0000000000000000";

    public static UUIDGenerator get()
    {
        return INSTANCE;
    }

    private long count;

    private final String random;

    {
        if (GWT.isScript())
        {
            random = format(Random.nextInt(), 12);
        }
        else
        {
            random = format(System.identityHashCode(this), 12);
        }
    }

    /**
     * Возвращает случайный идентификатор
     * 
     * @return случайный идентификатор
     */
    public String nextUUID()
    {
        long time = System.currentTimeMillis();
        long currentCount = count++;

        String p0 = "f" + format(time & 0xFFFFFFFl, 7);
        String p1 = format((time & 0xFFFF0000000l) >> 28, 4);
        String p2 = format(currentCount & 0xFFFFl, 4);
        String p3 = format((currentCount & 0xFFFF0000l) >> 16, 4);

        return p0 + "-" + p1 + "-" + p2 + "-" + p3 + "-" + random;
    }

    String format(long value, int length)
    {
        String strValue = Long.toHexString(value);
        return ZEROS.substring(0, length - strValue.length()) + strValue;
    }
}
