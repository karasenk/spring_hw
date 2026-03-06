const usernameField = document.getElementById("username");
const passwordField = document.getElementById("password1");
const repeatedPasswordField = document.getElementById("password2");

function validateUsername(){
    if (usernameField.value == ""){
        alert("Имя пользователя не может быть пустым.")
    }
}

function validatePassword(){
    const regex = "^(?=.*[0-9])" + // содержит цифры
                  "(?=.*[a-z])" + // содержит маленькие буквы
                  "(?=.*[A-Z])" + // содержит большие буквы
                  "(?=\\S+$)" + // не содержит пробел
                  ".{8,32}$"; // от 8 до 32 символов
    if (!regex.test(passwordField.value)){
        alert("Пароль должен содержать цифры, большие и маленькие латинские буквы, не должен содержать пробелов. Длина от 8 до 32 символов.")
        return false;
    }
}

function matchingPasswords(){
    if (repeatedPasswordField.value != passwordField.value){
        alert("Пароли не совпадают.")
    }
}

usernameField.addEventListener("input", validateUsername);
passwordField.addEventListener("input", validatePassword);
repeatedPasswordField.addEventListener("input", matchingPasswords);
