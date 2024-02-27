<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Goldeneye</title>
</head>

<body>
    <h1>Goldeneye</h1>
    <form action="/email" method="POST" modelAttribute="employee">
        <table>
            <tr>
                <td><label for="firstName"> First Name</label></td>
                <td><input type="text" name="firstName" id="firstName" pattern="[A-ZÀ-ÿ][-,a-z. ']*"
                        title="Name can only contain letters" required /></td>
            </tr>
            <tr>
                <td><label for="surname">Surname</label></td>
                <td><input type="text" name="surname" id="surname" pattern="[A-ZÀ-ÿ][-,a-z. ']*"
                        title="Name can only contain letters" required /></td>
            </tr>
            <tr>
                <td><label for="department">Department</label></td>
                <td>
                    <select name="department" id="department" />
                    <option value="design">Design</option>
                    <option value="business">Business</option>
                    <option value="advertising">Advertising</option>
                    <option value="rnd">Research & development</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="office">Office</label></td>
                <td>
                    <select name="office" id="office" />
                    <option value="milan">Milan</option>
                    <option value="spain">Spain</option>
                    <option value="newyork">New York</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</body>

</html>