import * as React from 'react';
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import {Button, MenuItem, Select, Stack} from "@mui/material";
import Typography from "@mui/material/Typography";
import {useEffect, useState} from "react";
import {trialCreationStore} from "../stores/TrialCreationStore";
import {observer} from "mobx-react-lite";

function CreateTrial()
{
    const [disease, setDisease] = useState({})
    const handleSubmit = async (event) =>{
        event.preventDefault();

        trialCreationStore.postTrial().then(() =>{
            window.location.href= "/#/trials"
        })


    }



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
                                trialCreationStore.trialdata.trialname = e.target.value
                            }}
                        />
                        <TextField
                            required
                            id="outlined-required"
                            label="Company or org"
                            defaultValue=""
                            onChange={(e) =>{
                                trialCreationStore.trialdata.company.id = e.target.value
                            }}
                        />
                        <TextField
                            required
                            id="outlined-required"
                            label="Location"
                            defaultValue=""
                            onChange={(e) =>{
                                trialCreationStore.trialdata.location = e.target.value
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
                                           trialCreationStore.trialdata.description = e.target.value
                                       }}
                            />
                        </div>
                    </Grid>
                    <Grid item xs={5}>
                        <Stack direction={"row"} spacing={2}>
                            <Typography variant={"h6"}>
                                Medical specifications
                            </Typography>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={trialCreationStore.diseases}
                                label="Disease"
                                onChange={setDisease}>
                                {trialCreationStore.diseases.map(disease => (
                                    <MenuItem value={disease.id}> {disease.name}</MenuItem>
                                ))}
                            </Select>
                        </Stack>

                    </Grid>
                </Grid>
                <Button onClick={handleSubmit}>
                    Submit
                </Button>
            </div>

        </div>
    )
} export default observer(CreateTrial)