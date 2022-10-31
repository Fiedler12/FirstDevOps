import {Button, Card, CardActions, Fab, Grid, Typography} from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import{trialsStore} from "../stores/TrialsStore";

// const trials = [
//     {
//         id: 1,
//         Company: "CompanyName",
//         Trial: "TrialDescription containing different facts and specifications about the trial."
//     },
//     {
//         id: 2,
//         Company: "CompanyName",
//         Trial: "TrialDescription"
//     },
//     {
//         id: 3,
//         Company: "CompanyName",
//         Trial: "TrialDescription"
//     },
//     {
//         id: 4,
//         Company: "CompanyName",
//         Trial: "TrialDescription"
//     },
//     {
//         id: 5,
//         Company: "CompanyName",
//         Trial: "TrialDescription"
//     },
//     {
//         id: 6,
//         Company: "CompanyName",
//         Trial: "TrialDescription"
//     }
// ]

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
                {trialsStore(trial => (
                    <Grid item xs={4} sm={6} md={4} lg={4}>
                            <Card sx={6} >
                                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                    {trial.name}
                                </Typography>
                                <Typography variant="h5" component="div">
                                    {trial.Company}
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