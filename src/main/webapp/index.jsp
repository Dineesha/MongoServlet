<html>
<head>
    <title>Login</title>

    <style>
        table {
        border-collapse: collapse;
        border: 5px solid black;
        width:35%;
        margin: auto;
        margin-top: 10%;
        cell-padding: 10px;
        }
        td {
        padding: 15px;
        }
    </style>

</head>

<body>
<h2>Login!</h2>

<table>
    <form action="Login" method="post">
        <tr>
            <td width="35%">
                <label id="lblun">User Name: </label>
            </td>
            <td>
                <input type="text" name="txtUn" maxlength="100"/>
            </td>
        </tr>
        <tr>
            <td>
                <label id="lblPw">Password: </label>
            </td>
            <td>
                <input type="password" name="txtPw"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Login">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
