import {Button, Grid, TextField, Typography} from "@mui/material";


function Login() {
    return(
        <Grid
            container
            spacing={0}
            rowSpacing={2}
            direction="column"
            alignItems="center"
            justifyContent="center"
            style={{ minHeight: '70vh' }}>
            <Grid item>
                <Typography variant={"h4"}>
                    Login page
                </Typography>
            </Grid>
            <Grid item spacing={2}>
                <TextField id="outlined-basic" label="Email" variant="outlined" />
            </Grid>
            <Grid item>
                <TextField id="outlined-basic" label="Password" variant="outlined" />
            </Grid>
            <Grid item>
                <Button variant="contained" href={"#/homepage"}>Login</Button>
            </Grid>

        </Grid>

    )

}

export default Login;