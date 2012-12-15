/**
 * 
 */
package ru.naumen.nauchat.server.taskrunner;



/**
 * @author ivodopyanov
 * @since 15.12.2012
 * 
 */
public class Square implements MyFunction
{
    @Override
    public Double apply(Double input)
    {
        return input * input;
    }
}