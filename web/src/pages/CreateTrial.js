import * as React from 'react';
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import {Button, FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useState} from "react";
import {creationStore} from "../stores/TrialCreationStore";
import {diseaseStore} from "../stores/DiseaseStore"
import {observer} from "mobx-react-lite";

function CreateTrial()
{

    const [trialName, setTrialName] = useState("");
    const [companyName, setCompanyName] = useState("");
    const [disease, setDisease] = useState({id: -1});

    const handleSubmit = async (event) =>{
        event.preventDefault();
        let newDisease = {
            id: disease,
            name: ""
        }
        creationStore.trialdata.diseases.push(newDisease)
        creationStore.postTrial().then(() =>{
            window.location.href= "/#/trials"
        })
    }

    const handleChange = (event) => {
        setDisease(event.target.value)
    };


    return (
        <div>
            <h1>
                Create trial
            </h1>
            <div>
                <Grid container spacing={10}>
                    <Grid item xs={2} md={2}>
                        <TextField
                            required
                            id="outlined-required"
                            label="Trial name"
                            defaultValue=""
                            onChange={(e) =>{
                                creationStore.trialdata.trialname = e.target.value
                            }}
                        />
                        <TextField
                            required
                            id="outlined-required"
                            label="Company or org"
                            defaultValue=""
                            onChange={(e) =>{
                                creationStore.trialdata.company.id = e.target.value
                            }}
                        />
                        <TextField
                            required
                            id="outlined-required"
                            label="Location"
                            defaultValue=""
                            onChange={(e) =>{
                                creationStore.trialdata.location = e.target.value
                            }}
                        />

                    </Grid>
                    <Grid item xs={10} md={5}>
                        <div>
                            <TextField id="filled-multiline-flexible"
                                       label="Description"
                                       multiline
                                       rows={10}
                                       maxRows={20}
                                       fullWidth
                                       helperText="Describe the trial"
                                       variant="filled"
                                       onChange={(e) =>{
                                           creationStore.trialdata.description = e.target.value
                                       }}
                            />
                        </div>
                    </Grid>
                    <Grid item xs={3}>
                        <FormControl fullWidth>
                            <InputLabel id="demo-simple-select-label">Disease</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={disease}
                                label="Disease"
                                onChange={handleChange}>
                                {diseaseStore.diseases.map(disease => (
                                    <MenuItem value={disease.id}>{disease.name}</MenuItem>
                                ))}
                            </Select>
                        </FormControl>
                    </Grid>
                </Grid>
                <Button onClick={handleSubmit}>
                    Submit
                </Button>
            </div>

        </div>
    )
}
export default observer(CreateTrial)