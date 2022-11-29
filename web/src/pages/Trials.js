import {Button, Card, CardActions, Fab, Grid, TextField, Typography} from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import{trialsStore} from "../stores/TrialsStore";
import {useEffect, useState} from "react";
import {Box, Divider, FormControl, InputLabel, Select, MenuItem} from '@mui/material';
import {observer} from "mobx-react-lite";
import {diseaseStore} from "../stores/DiseaseStore";


function Trials() {
    const [disease, setDisease] = useState('Any');
    const [search, setSearch] = useState("");

    const handleChange = (event) => {
        setDisease(event.target.value);
    };

    function onButtonClick() {
        if(disease === 'Any' || disease === -1) {
            trialsStore.fetchTrials()
        }
        else {
            trialsStore.fetchSpecificDisease()
        }
    }


    return(
        <div>
            <h1>Trials
                <Fab href={"#/createTrials"} color="primary" aria-label="add" size="small">
                    <AddIcon/>
                </Fab>
            </h1>
            <Grid container
                  xs={12}
                  spacing={4}
                  alignItems="center"
                  justifyContent="center"
                  direction="row"
                  >
                <Grid item xs={3}>
                    <Box sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
                        <Box sx={{ my: 3, mx: 2 }}>
                            <Grid container alignItems="center">
                                <Grid item xs>
                                    <TextField onChange={(e) => {
                                        setSearch(e.target.value)
                                    }}
                                    >
                                        Search
                                    </TextField>
                                </Grid>
                                <Grid item>
                                    <Button>
                                        Minimize
                                    </Button>
                                </Grid>
                            </Grid>
                            <Typography color="text.secondary" variant="body2">
                                Here you can search for specific companies.
                            </Typography>
                        </Box>
                        <Divider variant="middle" />
                        <Box sx={{ m: 2 }}>
                            <Typography gutterBottom variant="body1">
                                Select a specific disease
                            </Typography>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Disease</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={disease}
                                    label="Disease"
                                    onChange={handleChange}>
                                    <MenuItem value={-1}>Any</MenuItem>
                                    {diseaseStore.diseases.map( disease => (
                                        <MenuItem value={disease.id}>{disease.name}</MenuItem>
                                        ))}

                                </Select>
                            </FormControl>
                        </Box>
                        <Box sx={{ mt: 3, ml: 1, mb: 1 }}>
                            <Button onClick={() => {
                                onButtonClick()
                            }}>Apply</Button>
                        </Box>
                    </Box>
                </Grid>
                <Grid item xs={8}>
                    <Grid container spacing={4}>
                        {trialsStore.trials.map(trial => (
                        <Grid item xs={12} sm={6} md={4} lg={4} key={trial.id}>
                            <Card>
                                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                    {trial.company.companyName}
                                </Typography>
                                <Typography variant="h5" component="div">
                                    {trial.trialname}
                                </Typography>
                                <Typography variant="h6" component="div">
                                    {trial.location}
                                </Typography>
                                <Typography variant="body2">
                                    {trial.description}
                                </Typography>
                                <CardActions>
                                    <Button size="small" href={`#/trialSignup/${trial.id}`}>Learn More</Button>
                                </CardActions>
                            </Card>
                    </Grid>
                ))}
                    </Grid>
                </Grid>
            </Grid>
        </div>
    )

}

export default observer(Trials);
