import axios from "axios"

const baseUrl = 'http://localhost:8080'

export const getUser = (username?: string) => {
    return axios.get(`${baseUrl}/user/${username}`);
}