const URLNavbarAdmin = 'http://localhost:8080/api/admin/showAccount/';
const navbarBrandAdmin = document.getElementById('navbarBrandAdmin');//Элемент, где будет роль и почта текущего юзера
const tableUserAdmin = document.getElementById('tableAdmin');//Элемент, где будет таблица текущего юзера

function getCurrentAdmin() {
    fetch(URLNavbarAdmin)
        .then((res) => res.json())
        .then((userAdmin) => {

            let data = '';

            const rolesString = userAdmin.authorities.map(role => role.authority).join(", ");
            data += `<tr>
            <td>${userAdmin.id}</td>
            <td>${userAdmin.username}</td>
            <td>${userAdmin.email}</td>
            <td>${rolesString}</td>
            </tr>`;
            tableUserAdmin.innerHTML = data;
            navbarBrandAdmin.innerHTML = `<b><span>${userAdmin.email}</span></b>
                             <span>with roles:</span>
                             <span>${rolesString}</span>`;
        });
}

getCurrentAdmin()

