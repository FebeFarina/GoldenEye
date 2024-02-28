<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Goldeneye</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
        }

        a {
            text-decoration: none;
            color: #000;
        }

        form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #6e6e6e;
        }

        table {
            width: 100%;
        }

        td {
            padding: 10px;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>
    <h1><a href="/">Goldeneye</a></h1>
    <form action="/email" method="POST" modelAttribute="employee">
        <table>
            <tr>
                <td><label for="firstName"> First Name</label></td>
                <td><input type="text" name="firstName" id="firstName" pattern="[A-Za-z ]{2,}"
                        title="Name can only contain letters, with minimum 2" required /></td>
            </tr>
            <tr>
                <td><label for="surname">Surname</label></td>
                <td><input type="text" name="surname" id="surname" pattern="[A-Za-z ]{2,}"
                        title="Name can only contain letters, with minimum 2" required /></td>
            </tr>
            <tr>
                <td><label for="department">Department</label></td>
                <td>
                    <select name="department" id="department" required />
                    <option disabled selected value>--</option>
                    <option value="design">Design</option>
                    <option value="business">Business</option>
                    <option value="advertising">Advertising</option>
                    <option value="researchdevelopment">Research & development</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="office">Office</label></td>
                <td>
                    <select name="office" id="office" required />
                    <option disabled selected value>--</option>
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

<script>

    document.getElementById('department').addEventListener('change', function () {
        var department = this.value;
        var office = document.getElementById('office');
        var options = office.options;

        office.value = '';

        for (var i = 0; i < options.length; i++) {
            var option = options[i];
            option.disabled = false;

            if (department === 'design' && (option.value === 'newyork' || option.value === 'spain')) {
                option.disabled = true;
            } else if (department === 'advertising' && (option.value === 'spain')) {
                option.disabled = true;
            } else if (department === 'researchdevelopment' && (option.value === 'milan' || option.value === 'newyork')) {
                option.disabled = true;
            }
        }
    })

</script>