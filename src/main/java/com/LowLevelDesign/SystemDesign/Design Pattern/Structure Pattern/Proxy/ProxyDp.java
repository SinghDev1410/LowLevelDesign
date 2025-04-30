package WopiHostApplication.File.Structure_Dp.Proxy;

public class ProxyDp {
    public static void main(String[] args) {
        try {
            EmployeeDao empTableObj = new EmployeeDaoProxy();
            EmployeeDa employee = new EmployeeDa();
            empTableObj.create("ADMIN", employee);  // Trying to create with USER
//            empTableObj.create("USER", employee);  // Trying to create with USER
            System.out.println("Operation successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

interface EmployeeDao {
    public void create(String client, EmployeeDa obj) throws Exception;
    public void delete(String client, int employeeId) throws Exception;
    public EmployeeDa EmployeeDo(String client, int employeeId) throws Exception;  // This should return EmployeeDa
}

class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void create(String client, EmployeeDa obj) throws Exception {
        // Create a new row
        System.out.println("Created new row in the Employee table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        // Delete a row
        System.out.println("Deleted row with employeeId " + employeeId);
    }

    @Override
    public EmployeeDa EmployeeDo(String client, int employeeId) throws Exception {
        // Fetch row
        System.out.println("Fetching data from the DB");
        return new EmployeeDa();  // Returning a new EmployeeDa object
    }
}

class EmployeeDaoProxy implements EmployeeDao {

    EmployeeDao employeeDaoObj;

    EmployeeDaoProxy() {
        employeeDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDa obj) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDaoObj.create(client, obj);
        } else {
            throw new Exception("Access Denied");
        }
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDaoObj.delete(client, employeeId);
        } else {
            throw new Exception("Access Denied");
        }
    }

    @Override
    public EmployeeDa EmployeeDo(String client, int employeeId) throws Exception {
        if (client.equals("ADMIN") || client.equals("USER")) {
            return employeeDaoObj.EmployeeDo(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}

class EmployeeDa {
    // Assuming this is a placeholder class for Employee data
    private String name;
    private int id;

    // Constructors, getters, and setters can be added as needed
    public EmployeeDa() {
        this.name = "John Doe";
        this.id = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}





// =================================================================================================


//public class ProxyDp {
//    public static void main(String[] args) {
//        try{
//            EmployeeDao empTableObj = new EmployeeDaoProxy();
//            empTableObj.create("USER", new EmployeeDa());
//            System.out.println("Operation successful");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
//
//interface EmployeeDao{
//    public void create(String client, EmployeeDa obj) throws Exception;
//    public void delete(String client, int employeeId) throws Exception;
//    public void EmployeeDo(String client, int employeeid) throws Exception;
//
//}
//
//
//class EmployeeDaoImpl implements EmployeeDao{
//
//    @Override
//    public void create(String client, EmployeeDa obj) throws Exception {
//        // create a new Row
//        System.out.println("created new row in the Employee table");
//    }
//
//    @Override
//    public void delete(String client, int employeeId) throws Exception {
//        // delete a row
//        System.out.println("deleted row with employeedId" + employeeId);
//    }
//
//    @Override
//    public void EmployeeDo(String client, int employeeid) throws Exception {
//        // fetch row
//        System.out.println("fetching data from the db");
//        return new EmployeeDa();
//    }
//}
//
//class EmployeeDaoProxy implements EmployeeDao{
//
//    EmployeeDao employeeDaoObj;
//    EmployeeDaoProxy(){
//        employeeDaoObj = new EmployeeDaoImpl();
//    }
//    @Override
//    public void create(String client, EmployeeDa obj) throws Exception {
//        if(client.equals("ADMIN")){
//            employeeDaoObj.create(client, obj);
//            return;
//        }
//        throw new Exception("Access Denied");
//    }
//
//    @Override
//    public void delete(String client, int employeeId) throws Exception {
//        if(client.equals("ADMIN")){
//            employeeDaoObj.delete(client,employeeId);
//            return;
//        }
//        throw new Exception("Access Denied");
//    }
//
//    @Override
//    public void EmployeeDo(String client, int employeeId) throws Exception {
//        if(client.equals("ADMIN")|| client.equals("USER")){
//            return employeeDaoObj.get(Client,employeeId);
//        }
//    }
//}
//
//
//class EmployeeDa {
//    // Assuming this is a placeholder class for Employee data
//    private String name;
//    private int id;
//
//    // Constructors, getters, and setters can be added as needed
//    public EmployeeDa() {
//        this.name = "John Doe";
//        this.id = 1;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
