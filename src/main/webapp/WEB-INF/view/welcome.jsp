<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<main>
    <div class="row w-100" style="background: rgb(111, 111, 111)">
        <div class="col-4">
            <h2 style="color: white">TaskManager</h2>
        </div>
    </div>
    <div class="row w-100">
        <div class="col-3" style="margin-top: 20px;">
            <form:form action="applicationLogic" modelAttribute="inputModel">
                <div class="row" style="margin-left: 10px">
                    <h5 class="col-4">userName</h5>
                    <div class="col-8"><form:input path="userName" /></div><br><br>

                    <h5 class="col-4">firstName</h5>
                    <div class="col-8"><form:input path="firstName" /></div><br><br>

                    <h5 class="col-4">lastName</h5>
                    <div class="col-8"><form:input path="lastName" /></div><br><br>

                    <h5 class="col-4">taskTittle</h5>
                    <div class="col-8"><form:input path="taskTittle" /></div><br><br>

                    <h5 class="col-4">taskDescription</h5>
                    <div class="col-8"><form:input path="desc" /></div><br><br>

                    <h5 class="col-4">Command</h5>
                    <div class="col-8">
                        <form:select path="commandName">
                            <form:option value="createuser" label="Create user"/>
                            <form:option value="addtask" label="Add task to user"/>
                            <form:option value="showusers" label="Show users"/>
                            <form:option value="showusertask" label="Show user task"/>
                        </form:select>
                    </div><br><br>
                    <div class="col-12"><button type="submit" class="btn btn-dark">Submit</button></div>

                </div>
            </form:form>
        </div>
    </div>
</main>

</body>
</html>