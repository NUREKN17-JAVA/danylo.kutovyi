package ua.nure.kn.kutovoy;

import java.util.Calendar;

import junit.framework.TestCase;

public class UserTest extends TestCase {

    // first person
    private static final int DAY_OF_BIRTH = 22;
    private static final int MONTH_OF_BIRTH = 01;
    private static final int YEAR_OF_BIRTH = 2000;
    private static final int ETHALON_AGE = 19;

    // second person
    private static final int MONTH_OF_BIRTH_1 = 4;
    private static final int ETALON_AGE_1 = 21;

    private User user;

    public void testGetFullName() {
        user.setFirstName("Stepan");
        user.setLastName("Angelov");
        assertEquals("Angelov Stepan", user.getFullName());
    }

    public void testGetAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
        user.setDateOfBirth(calendar.getTime());
        assertEquals(ETHALON_AGE, user.getAge());
    }

    public void testGetAge1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_1, DAY_OF_BIRTH);
        user.setDateOfBirth(calendar.getTime());
        assertEquals(ETALON_AGE_1, user.getAge());
    }

    public void testAgeHappyBirthdayTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, 9);
        user.setDateOfBirth(calendar.getTime());
        int realAge = user.getAge();
        assertEquals(ETHALON_AGE, realAge);
    }

    public void testArrivalAge() {
        int supposedAge = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        user.setDateOfBirth(calendar.getTime());
        int realAge = user.getAge();
        assertEquals(supposedAge, realAge);
    }

    public void testAgeHappyBirthdayToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        user.setDateOfBirth(calendar.getTime());
        int realAge = user.getAge();
        assertEquals(ETHALON_AGE, realAge);
    }

    protected void setUp() throws Exception {
        super.setUp();
        user = new User();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

