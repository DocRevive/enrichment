import java.util.Date;

/**
 * Converting discord IDs to dates and vice versa.
 * https://discord.com/developers/docs/reference#snowflakes
 *
 * @author Daniel Kim
 * @version 5-3-22
 */
public class SnowflakeTime {
    public static void main(String[] args)
    {
        System.out.println(toDate(723223807845729387L));
        System.out.println(toSnowflake(new Date(1473293669000L)));
    }

    /**
     * Converts a snowflake to the date it was created.
     *
     * @param  id  discord snowflake
     * @return     Date of snowflake
     */
    public static Date toDate(long id)
    {
        return new Date((id >> 22) + 1420070400000L);
    }

    /**
     * Generates a snowflake from a date.
     *
     * @param  datetime  datetime of creation
     * @return           snowflake
     */
    public static long toSnowflake(Date datetime)
    {
        return (datetime.getTime() - 1420070400000L) << 22;
    }
}
