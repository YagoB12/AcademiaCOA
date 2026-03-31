import { useEffect, useState } from 'react';
import { listStudents } from '../../services/StudentService';


const StudentList = () => {

  const [student, setStudent] = useState<any[]>([]);
   
  useEffect(() => {
  
    listStudents().then((response) => {
      setStudent(response.data);
    }).catch(error => { 
      console.error("Error fetching student data:", error);
    })
  
  }, []);
 
 
  return (
    <div className="container">
      <h2>Lista de estudiantes</h2>
      <table className="table table-striped table-bordered">
        <tr>
          <th>#</th>
          <th>Identificacion</th>
          <th>Nombre</th>
          <th>Apeillido</th>
          <th>Edad</th>
          <th>Email</th>
          <th>Ruta de imagen</th>
          <th>Fecha de registro</th>
          <th>Estado</th>
          <th>Progreso</th>
          <th>Acciones</th>
        </tr>
        <tbody>
          {
            student.map((emp, index) =>
              
              <tr key={emp.id}>
                <th>{index+1}</th>
                <th scope="row">{emp.identification}</th>
                <td>{emp.name}</td>
                <td>{emp.lastName}</td>
                <td>{emp.age}</td>
                <td>{emp.email}</td>
                <td>{emp.img}</td>
                <td>{emp.dateRegister}</td>
                <td>{emp.status ==1? "Activo": "inactivo"}</td>
                <td>{emp.progress}</td>
              </tr>

            )
          }

        </tbody>
      </table>







    </div>
  )
}

export default StudentList