<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Goldeneye</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        a {
            text-decoration: none;
            color: #000;
        }

        .button {
            width: 25%;
            max-height: 10%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }
    </style>
</head>

<body>
    <h1>Result</h1>
    <p>Your email is ${email}</p>
    <a href="/email" class="button"> Get another email </a>
</body>

</html>