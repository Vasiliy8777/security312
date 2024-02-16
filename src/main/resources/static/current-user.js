const URLNavbarUser = 'http://localhost:8080/api/user';
const navbarBrandUser = document.getElementById('navbarBrandUser'); //Элемент, где будет роль и почта текущего юзера
const tableUserUser = document.getElementById('tableUser');//Элемент, где будет таблица текущего юзера
function getCurrentUser() {
    fetch(URLNavbarUser)
        .then((res) => res.json())
        .then((user) => {

            let dataOfUser = '';

            const rolesString = user.authorities.map(role => role.authority).join(", ");

            dataOfUser += `<tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${rolesString}</td>
            </tr>`;
            tableUserUser.innerHTML = dataOfUser;
            navbarBrandUser.innerHTML = `<b><span>${user.email}</span></b>
                             <span>with roles:</span>
                             <span>${rolesString}</span>`;
        });
}

getCurrentUser()




