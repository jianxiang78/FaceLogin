import axIos from "axios";

// Modify the following address according to your environment
const serverUrl='http://localhost:8080';

const instanceForm=axIos.create({
    baseURL: serverUrl,
    headers: {
        "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        "Access-Control-Allow-Origin": "*"
    }
});

const instanceJson=axIos.create({
    baseURL: serverUrl,
    headers: {
        "Content-Type": "application/json; charset=utf-8",
        "Access-Control-Allow-Origin": "*"
    }
});

function getAuthorization () {
    let Author = sessionStorage.getItem('Authorization')
    if (Author === null) return ''
    return Author
}

instanceForm.interceptors.request.use(
    (config) => {
        config.headers.authorization = getAuthorization()
        return config
    }
)

instanceJson.interceptors.request.use(
    (config) => {
        config.headers.authorization = getAuthorization()
        return config
    }
)

const instance = (type) => {
    if(type==='form'){
        return instanceForm
    }
    if(type==='json'){
        return instanceJson
    }
}

export default instance;
