<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap');

        html, body {
            font-family: "Montserrat", sans-serif;
        }

        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 1.1rem 5rem;
            background: linear-gradient(180deg, #6fb4fd 0%, #5caafc 100%);
        }

        .brand a {
            text-decoration: none;
            font-size: 1.2rem;
            font-weight: 600;
            color: #fff;
        }

        ul {
            display: flex;
            flex-direction: row;
        }

        li {
            list-style-type: none;
            margin-left: 3rem;
        }

        li > a{
            text-decoration: none;
            color: #fff;
            font-size: 0.9rem;
            font-weight: 500;
        }


        li::after {
            content: '';
            width: 0rem;
            height: 0.15rem;
            background-color: #fff;
            display: block;
            border-radius: 0.2rem;
            margin: 0.2rem auto 0 auto;
            transition: all 0.3s ease-in-out;
        }

        li:hover::after {
            width: 2rem;
        }
    </style>
</head>
    <body>
        <header>
            <div class="brand"><a href="/">Production by JusTony</a></div>

            <nav>
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/login-form">Login</a></li>
                    <li><a href="/register-form">Register</a></li>
                    <li><a href="/users">Users</a></li>
                </ul>
            </nav>
        </header>
    </body>
</html>