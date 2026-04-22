const BASE_URL = "http://localhost:8080";
let token = "";

// REGISTER
function register() {
    fetch(BASE_URL + "/auth/register", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            name: document.getElementById("name").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        })
    }).then(() => alert("Registered"));
}

// LOGIN
function login() {
    fetch(BASE_URL + "/auth/login", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            email: document.getElementById("loginEmail").value,
            password: document.getElementById("loginPassword").value
        })
    })
    .then(res => res.text())
    .then(t => {
        token = t;
        alert("Login success");
    });
}

// LOAD COURSES (SECURED)
function loadCourses() {
    fetch(BASE_URL + "/courses", {
        headers: {
            "Authorization": "Bearer " + token
        }
    })
    .then(res => res.json())
    .then(data => {
        let list = document.getElementById("courses");
        list.innerHTML = "";

        data.forEach(c => {
            let li = document.createElement("li");
            li.innerText = c.title;
            list.appendChild(li);
        });
    });
}