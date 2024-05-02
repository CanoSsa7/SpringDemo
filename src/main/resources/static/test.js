document.addEventListener('DOMContentLoaded', function () {
    var loginButton = document.getElementById('loginButton');
    loginButton.addEventListener('click', function() {
        var username = document.getElementById('username').value;
        var password = document.getElementById('pwd').value;
        var data = JSON.stringify({
            username: username,
            pwd: password
        });

        loginButton.disabled = true; // 禁用按钮，防止重复提交
        var request = new XMLHttpRequest();
        request.open("POST", "http://localhost:8080/login", true);
        request.setRequestHeader("Content-Type", "application/json");
        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                loginButton.disabled = false; // 请求完成后重新启用按钮
                try {
                    var response = JSON.parse(request.responseText);
                    if (response.code === 1) {
                        alert('登录成功');
                    } else {
                        alert('登录失败: ' + response.msg); // 提示具体的错误信息
                    }
                } catch (e) {
                    alert('登录失败: 无法解析服务器响应');
                }
            }
        };
        request.send(data);
    });
});


function inputPwd() {
    let e = document.getElementById("pwd")
    let str = e.value
    if (str.length >= 6){
        e.removeAttribute("class")
    }else{
        e.setAttribute("class", "pwdInputIllegal")
    }
}
