import * as React from 'react';
import { Container, Paper, Button, TextField} from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';

 
 

const useStyle=makeStyles((theme)=>({
    root:{
        '& > * ':{
            margin: theme.spacing(1),
        },
    },
}));

function Student() {
    const paperStyle={padding:'50px 20px',width:600,margin:'20px auto'}
    const[fullName,setfullName]=React.useState('')
    const[email,setEmail]=React.useState('')
    const[students,setStudents]=React.useState([])
    const classes = useStyle();
    

    const takeTheClick=(e)=>{
        e.preventDefault()
        const student={fullName, email}
        console.log(student)
        fetch("http://localhost:8080/students/",{
            method:'POST',
            headers:{'Content-Type': 'application/json'
        },
            cache: 'default',
            body:JSON.stringify(student)
        }).then(()=>{console.log("New student successfully added!")} )
    }
 
    React.useEffect(()=>{
        const url='http://localhost:8080/students/';//api url
        fetch(url).then(ans=>ans.json())//calling url by method GET
        .then(answer=>setStudents(answer))//setting response to state posts
      },[])
  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h2>Home Page </h2>
            <form className = {classes.root} noValidate autoComplete="off"> 
        <TextField id="outlined-basic" label="Student name" variant="outlined" fullWidth
        value={fullName} onChange={(e)=>setfullName(e.target.value)}/>
        <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth 
        value={email} onChange={(e)=>setEmail(e.target.value)}/>
        <Button variant="contained" color="primary" onClick={takeTheClick}>Add Student</Button>
            </form>
            {fullName} {email}
            
      </Paper>
        {/* code will be bring here/ */}
      <Paper elevation={3} style={paperStyle}>
       {/*  {students.map(student=>(
            <div elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={student.id}>
                    Id: {student.id}
                    fullname:{student.fullName}
            </div>   
            ))
    } */}
      </Paper>
    </Container>
    
  );
}
export default Student