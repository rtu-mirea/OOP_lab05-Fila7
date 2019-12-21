import java.io.Serializable;
import java.util.ArrayList;

public class Tester implements Serializable {
    public ArrayList<User> users = new ArrayList<User>();
    public ArrayList<Test> tests = new ArrayList<Test>();
    public void addUser(String name, String login, String password)
    {
        users.add(new TestedUser(name, login, password));
    }
    public int findUser(String login, String password)
    {
        for (int i = 0;i<users.size();i++)
            if(users.get(i).enter(login, password))
                return i;
        throw new IllegalArgumentException("Такого пользователя нет, попробуйте снова");
    }
    public ArrayList getResults()
    {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 1; i < users.size(); i++)
            res.add(users.get(i).getSuccess());
        return res;
    }
    public ArrayList getTests()
    {
        ArrayList<String> res = new ArrayList<String>();
        for(Test t:tests)
            res.add(t.getName());
        return res;
    }
    public void addTest(Test t)
    {
        tests.add(t);
    }
    public Tester() {
        users.add(new Admin("admin", "123", "qwe"));
    }
}
