<html>
<head>
    <title>Login</title>



</head>

<body>
<h2>Login</h2>


    <form action="loginServlet" method="post">
               <fieldset style="width: 300px">
                   <legend> Login to App </legend>
                   <table>
                       <tr>
                           <td>User ID</td>
                           <td><input type="text" name="username" required="required" /></td>
                       </tr>
                       <tr>
                           <td>Password</td>
                           <td><input type="password" name="password" required="required" /></td>
                       </tr>
                       <tr>
                           <td><input type="submit" value="Login" /></td>
                       </tr>

               </fieldset>
           </form>
</table>
</body>
</html>
