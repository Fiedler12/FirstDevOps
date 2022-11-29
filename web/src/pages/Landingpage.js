import {Button, Grid, Stack, Typography} from "@mui/material";
import logo from '../Logo/Probelogo.png';
import {tokenstore} from "../stores/TokenStore";

function Landingpage() {
    return(
        <Grid
            container
            spacing={4}
            rowSpacing={3}
            columnSpacing={5}
            paddingLeft={20}
            direction="row"
            alignItems="center"
            justifyContent="center"
            style={{ minHeight: '80vh'}}>

            <Grid item xs={12} sm={5} style={{width: '20%'}}>
                <Typography variant={"h2"}>
                    This is the landing page.
                </Typography>
                <Typography variant={"h5"} sx={{paddingTop:5, width: '80%'}}>
                    If you want to use the service you need to sign in. If you don't have an account yet, the click sign up and create one.
                </Typography>
                {tokenstore.token ? <div/> :
                    <Stack direction={"row"} spacing={2} sx={{paddingTop: 7}}>
                        <Button variant={"contained"} size={"large"} href={"#/signin"}
                                sx={{paddingRight: 7, paddingLeft: 7, fontSize: 20}}>
                            Sign in
                        </Button>
                        <Button variant={"contained"} size={"large"} href={"#/signup"}
                                sx={{paddingRight: 7, paddingLeft: 7, fontSize: 20}}>
                            Sign up
                        </Button>
                    </Stack>
                }
            </Grid>

            <Grid item xs={12} sm={6} style={{width: '50%'}}>
                <img src={logo} alt={"logo"} style={{width: 400, height: 400}}/>
            </Grid>




        </Grid>
    )

}

export default Landingpage;