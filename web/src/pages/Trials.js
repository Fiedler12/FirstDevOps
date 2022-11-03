import {Button, Card, CardActions, Fab, Grid, Typography} from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import{trialsStore} from "../stores/TrialsStore";
import {observer} from "mobx-react-lite";


function Trials() {
    return(
        <div>
            <h1>Trials
                <Fab href={"#/createTrials"} color="primary" aria-label="add" size="small">
                    <AddIcon/>
                </Fab>
            </h1>

            <Grid container
                  maxWidth="lg"
                  spacing={4}
                  alignItems="center"
                  justifyContent="center"
                  direction="row"
                  >
                {trialsStore.trials.map(trial => (
                    <Grid item xs={4} sm={6} md={4} lg={4}>
                            <Card sx={6}>
                                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                    {trial.company}
                                </Typography>
                                <Typography variant="h5" component="div">
                                    {trial.trialname}
                                </Typography>
                                <Typography variant="h7" component="div">
                                    {trial.location}
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

export default observer(Trials);
