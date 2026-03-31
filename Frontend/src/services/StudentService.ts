import axios from "axios";


const API_URL_STUDENT_LIST = "http://localhost:9999/student/list";

export const listStudents = () => axios.get(API_URL_STUDENT_LIST);