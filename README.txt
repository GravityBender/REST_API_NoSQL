Java version required: 17+
NoSQL Database used: MongoDB
Spring Boot version: 3.1.1

Hosting of the MongoDB database is done locally. The database name is given as "Assignment" in the application.properties file. If the database name is to be changed, then change it from the application.properties file.
The spring boot project is defined to run at the port 8090 on the localhost. It can be changed from the application.properties file.

To run the application, run the AssignmentApplication.java file.
Once, the initialization is complete the app will prepopulate some data into the mongodb "Assignment" collection of the "Assignment" database. Even if the database and collection are not defined, the app would create an instance of both, so do not change them.
If you wish to change the collection name, then change the name assigned in the "@Document" annotation in the Employee.java class in the package "com.assignment.assignment.model".

The basic url to call the rest endpoints is: "http://localhost:8090/api"

Documentation for EmployeeController.java class (All the REST endpoints are defined in this rest controller):

getAllEmployees(): This method retrieves a list of all employees from the employeeService and returns it in a ResponseEntity object. If the list is empty, it returns a ResponseEntity with an HTTP status code of NO_CONTENT. If an exception occurs, it returns a ResponseEntity with an HTTP status code of INTERNAL_SERVER_ERROR.
                    API Endpoint: http://localhost:8090/api/getAll  {GET Request}

getAllEmployees(String sortBy, int pageNo, int pageSize): This method retrieves a list of employees from the employeeService using pagination and sorting parameters. The method takes in three parameters: sortBy, which specifies the field to sort by; pageNo, which specifies the page number to retrieve; and pageSize, which specifies the number of employees to retrieve per page. The method returns a ResponseEntity object containing a map with the page number, page size, and list of employees. If an exception occurs, it returns a ResponseEntity with an HTTP status code of BAD_REQUEST.
                    API Endpoint: http://localhost:8090/api/getAllByPage?sortBy=xyc&pageNo=0&pageSize=3 {GET Request}

getEmployeeById(String id): This method retrieves an employee by their ID from the employeeService and returns it in a ResponseEntity object. If the employee is not found, it returns a ResponseEntity with an HTTP status code of NOT_FOUND.
                    API Endpoint: http://localhost:8090/api/get/{insert the employee id here}   {GET Request}

getNthManager(String id, Integer n): This method retrieves the Nth manager of an employee specified by their ID from the employeeService. The method takes in two parameters: id, which specifies the ID of the employee; and n, which specifies the number of levels up to retrieve the manager. The method returns a ResponseEntity object containing the Nth manager. If the manager is not found, it returns a ResponseEntity with an HTTP status code of NOT_FOUND. If an exception occurs, it returns a ResponseEntity with an HTTP status code of INTERNAL_SERVER_ERROR.
                    API Endpoint: http://localhost:8090/api/getNthManager/{insert employee id whose manager is to be found}/{level no.} {GET Request}

createEmployee(Employee emp): This method creates a new employee using the information provided in the request body and saves it using the employeeService. The method takes in one parameter: emp, which is an instance of the Employee class containing the information about the new employee. The method returns a ResponseEntity object containing the created employee with an HTTP status code of CREATED. If an exception occurs, it returns a ResponseEntity with an HTTP status code of NOT_ACCEPTABLE.
                    API Endpoint: http://localhost:8090/api/create  {POST Request}
                    JSON Body example  :    {
                                                    "employeeName": "h",
                                                    "phoneNumber": 913472147,
                                                    "empEmail": "h@gmail.com",
                                                    "reportsTo": "8cb156f5-218d-4c6a-9650-34006317ac24",
                                                    "empImgUrl": "https://h.com"
                                                }
                    There is no need to provide the id string when creating an employee, as the createEmployee() function in the service layer would create it automatically.

updateEmployee(Employee employee): This method updates an existing employee using the information provided in the request body and saves it using the employeeService. The method takes in one parameter: employee, which is an instance of the Employee class containing the updated information about the employee. The method returns a `ResponseEntity object containing the updated employee with an HTTP status code of ACCEPTED. If the employee is not found, it returns a ResponseEntity with an HTTP status code of NOT_FOUND.
                    API Endpoint: http://localhost:8090/api/update  {PUT Request}
                    JSON Body example   :   {
                                                "id": "c6b8b288-5c30-437c-a2cc-9ae8f9004cd7",
                                                "empEmail": "f@gmail.com"
                                            }
                    Make sure to include the employee id into the json body whenever that particular employee is to be updated. There is no need to specify all the fields except the field that has to be updated and the id field.

deleteEmployee(String id): This method deletes an employee specified by their ID using the employeeService. The method takes in one parameter: id, which specifies the ID of the employee to delete. The method returns a ResponseEntity object with an HTTP status code of OK if the deletion is successful. If an exception occurs, it returns a ResponseEntity with an HTTP status code of INTERNAL_SERVER_ERROR.
                    API Endpoint: http://localhost:8090/api/delete/{employee id here}  {DELETE Request}


General JSON Structure of Employee Object:
{
        "id": "6fb9eafd-9b45-47bc-8a4e-4d663d92c97f",
        "employeeName": "e",
        "phoneNumber": 423472147,
        "empEmail": "e@gmail.com",
        "reportsTo": null,
        "empImgUrl": "https://e.com"
}

Whenever the createEmployee endpoint is called the program would try to email the specified email of the 1st level manager. If testing is to be done without sending an email, then comment out the "try-catch" block in the createEmployee() function of the EmployeeService.java class.
To make sure the email reaches the correct destination, please create an employee document with a valid email address and then set the "reportsTo" field of the new employee document to the id of the employee document having a valid email.
You can also add valid emails to the initial data defined in the run method of the AssignmentApplications.java class.