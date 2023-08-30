<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Our Website</title>
    <style>
        body{
            background: black;
            color: aliceblue;
            font-family: Arial, Helvetica Neue, sans-serif;
        }
        header{
            background: white;
            padding: 20px;

        }
        h1{
            color: black;
        }
        nav{
            
            color: black;
            display: inline;
            width: 100px;
        }
        section{
            background: white;
            
        }
        main{
            color: black;
        }
        footer{
            background: white;
            color: black;
        }
    </style>
</head>
<body>
    <header>
        <h1>Visit Our Git Website</h1>
        <nav>
            <ul>
                <li><a href="https://github.com/GilEmanuel22">Gil Emanuel</a></li>
                <li><a href="https://github.com/maychook6">May Vakrat</a></li>
                <li><a href="https://github.com/RobiBar1">Reuven Bar</a></li>
                <li><a href="https://github.com/YairBuryak">Yair Buryak</a></li>
            </ul>
        </nav>
    </header>
    <section>
        <main>
            <h1>Rate Us</h1>
            <ul id="checkList">
                <li >
                    <span>Gil Emanuel</span>
                    <input id="gil_in" value=""/>
                    <p id="gil_grade"></p>
                    <button id="gil_btn" onclick="getValue('gil_grade','gil_in')">Save Grade</button>
                </li>
                <li>
                    <span>May Vakrat</span>
                    <input id="may_in" value=""/>
                    <p id="may_grade"></p>
                    <button id="may_btn" onclick="getValue('may_grade','may_in')">Save Grade</button>
                </li>
                <li>
                    <span>Reuven Bar</span>
                    <input id="reuven_in" value=""/>
                    <p id="reuven_grade"></p>
                    <button id="reuven_btn" onclick="getValue('reuven_grade','reuven_in')">Save Grade</button>
                </li>
                <li>
                    <span>Yair Buryak</span>
                    <input id="yair_in" value=""/>
                    <p id="yair_grade"></p>
                    <button id="yair_btn" onclick="getValue('yair_grade','yair_in')">Save Grade</button>
                </li>
            </ul>
        </main>
    </section>
    <footer>Thank You</footer>
    <script>
        function getValue(out,input){
            document.getElementById(out).innerHTML = document.getElementById(input).value;
        }
    </script>
</body>
</html>