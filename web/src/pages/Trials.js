import {Button, Card, CardActions, Grid, Typography} from "@mui/material";

const trials = [
    {
        id: 1,
        Company: "CompanyName",
        Trial: "TrialDescription containing different facts and specifications about the trial."
    },
    {
        id: 2,
        Company: "CompanyName",
        Trial: "TrialDescription"
    },
    {
        id: 3,
        Company: "CompanyName",
        Trial: "TrialDescription"
    },
    {
        id: 4,
        Company: "CompanyName",
        Trial: "TrialDescription"
    },
    {
        id: 5,
        Company: "CompanyName",
        Trial: "TrialDescription"
    },
    {
        id: 6,
        Company: "CompanyName",
        Trial: "TrialDescription"
    }
]

function Trials() {
    return(
        <div>
            <h1>Trials</h1>
            <Grid container
                  maxWidth="lg"
                  spacing={4}
                  alignItems="center"
                  justifyContent="center"
                  direction="row">
                {trials.map(trial => (
                    <Grid item xs={4}>
                            <Card sx={6} >
                                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                    Trial
                                </Typography>
                                <Typography variant="h5" component="div">
                                    {trial.Company}
                                </Typography>
                                <Typography variant="body2">
                                    {trial.Trial}
                                </Typography>
                                <CardActions>
                                    <Button size="small">Learn More</Button>
                                </CardActions>
                            </Card>
                    </Grid>
                ))}
            </Grid>
        </div>
    )

}

export default Trials;