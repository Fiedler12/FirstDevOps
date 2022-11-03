import {Button, Card, CardActions, Fab, Grid, Typography} from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import{trialsStore} from "../stores/TrialsStore";

const trialtest = ({id, companyid, trialname}) => {
return (
        <div>
            <h1>Trial number {id}</h1>
            <h2>{companyid}</h2>
            <h2>{trialname}</h2>
        </div>
    );

}

function Trials() {
    return(
        <div>
            <h1>Trials
                <Fab href={"#/createTrials"} color="primary" aria-label="add" size="small">
                    <AddIcon/>
                </Fab>
            </h1>
            <div>
                {console.log("Hello")}
                {console.log(trialsStore.trials.entries())}
            </div>
            <div>
                {trialsStore.trials.map((trialtest) => (
                    <p>
                        <span>ID: {trialtest.id}</span>
                        <span> Name: {trialtest.trials.entries()}</span>
                    </p>


                ))}
            </div>

            <Grid container
                  maxWidth="lg"
                  spacing={4}
                  alignItems="center"
                  justifyContent="center"
                  direction="row"
                  >
                {trialsStore.trials.map(trial => (
                    <Grid item xs={4} sm={6} md={4} lg={4}>
                            <Card sx={6} >
                                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                    {trial.name}
                                </Typography>
                                <Typography variant="h5" component="div">
                                    {trial.company}
                                </Typography>
                                <Typography variant="body2">
                                    {trial.description}
                                </Typography>
                                <CardActions>
                                    <Button size="small" href={"#/trialSignup"}>Learn More</Button>
                                </CardActions>
                            </Card>
                    </Grid>
                ))}
            </Grid>
        </div>
    )

}

export default Trials;