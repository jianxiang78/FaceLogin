import httpClient from "./http-common";


const isUserLoggedIn=()=> {
    let Author = sessionStorage.getItem('Authorization')
    if (Author === null || Author.length<2) return false
    return true
}

const getAuth = () => {
    let Author = sessionStorage.getItem('Authorization')
    if (Author === null) return ''
    return Author
}

const setAuthorization = (Auth) => {
    sessionStorage.setItem('Authorization',Auth)
}


const getLoggedUserName =()=> {
    let user = sessionStorage.getItem('userName')
    if (user === null) return ''
    return user
}

const setLoggedUserName =(userName)=> {
    sessionStorage.setItem('userName',userName)
}

const logout =()=> {
    sessionStorage.removeItem('userRole');
    sessionStorage.removeItem('userName');
    sessionStorage.removeItem('Authorization');
}

const exeForm = (url,data) => {
    return httpClient('form').post(url,data)
}

const exeJson = (url,data) => {
    return httpClient('json').post(url,data)
}

const checkLogin = (data) => {
    if(data.code===500){
        return (
            window.location.href='#/login'
        )
    }
}

const exportedObject = {
    exeForm,
    exeJson,
    isUserLoggedIn,
    getLoggedUserName,
    setLoggedUserName,
    setAuthorization,
    getAuth,
    logout,
    checkLogin
};

export default exportedObject;
