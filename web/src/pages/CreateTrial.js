import * as React from 'react';
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import {Button, Fab, Stack} from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import Typography from "@mui/material/Typography";
import {useEffect, useState} from "react";
import {creationStore} from "../stores/TrialCreationStore";

export default function CreateTrial()
{

    const [trialName, setTrialName] = useState("");
    const [companyName, setCompanyName] = useState("");

    const handleSubmit = async (event) =>{
        event.preventDefault();
        console.log("Hello")

        creationStore.postTrial().then(() =>{
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
                    <Grid item xs={5}>
                        <Stack direction={"row"} spacing={2}>
                            <Typography variant={"h6"}>
                                Medical specifications
                            </Typography>
                            <Fab color="primary" aria-label="add" size="small">
                                <AddIcon/>
                            </Fab>
                        </Stack>

                    </Grid>
                </Grid>
                <Button onClick={handleSubmit}>
                    Submit
                </Button>
            </div>

        </div>
    )
}