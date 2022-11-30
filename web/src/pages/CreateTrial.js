import * as React from 'react';
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import {
    Button,
    List,
    ListItem, ListItemButton,
    ListItemText
} from "@mui/material";
import {Component, useState} from "react";
import {creationStore} from "../stores/TrialCreationStore";
import {diseaseStore} from "../stores/DiseaseStore"
import {observer} from "mobx-react-lite";
import Box from "@mui/material/Box";
import * as PropTypes from "prop-types";
import Checkbox from "@mui/material/Checkbox";

function CreateTrial()
{
    const [trialName, setTrialName] = useState("");
    const [companyName, setCompanyName] = useState("");
    const [disease, setDisease] = useState({id: -1});
    const [checked, setChecked] = React.useState([]);

    const handleSubmit = async (event) =>{
        event.preventDefault();
        console.log("Submitting");

        for (let i = 0; i < checked.length; i++) {
            creationStore.trialdata.diseases.push(diseaseStore.diseases[checked[i]]);
            //I FUCKING HATE FRONTEND DEVELOPMENT
        }
        creationStore.postTrial().then(() =>{
            creationStore.trialdata = {
                company:{
                    id:1
                },
                trialname:"",
                location:"",
                description:"",
                diseases: [],
            }
            window.location.href= "/#/trials"
        })
    }

    const handleToggle = (value) => () => {
        const currentIndex = checked.indexOf(value);
        const newChecked = [...checked];

        if (currentIndex === -1) {
            newChecked.push(value);
        } else {
            newChecked.splice(currentIndex, 1);
        }
        setChecked([...newChecked]);
    };

    return (
        <div>
            <h1>
                Create trial
            </h1>
            <div>
                <Grid container spacing={5}>
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
                    <Grid item xs={3} md={3}>
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
                        <Box
                            sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}
                        >
                            <List>
                                {diseaseStore.diseases.map((disease, value) => (
                                    <ListItem
                                        key={disease.id}
                                        secondaryAction={
                                            <Checkbox
                                                edge="end"
                                                onChange={handleToggle(value)}
                                                checked={checked.indexOf(value) !== -1}
                                            />
                                        }
                                        disablePadding
                                    >
                                        <ListItem>
                                            <ListItemText primary={disease.name} />
                                        </ListItem>
                                    </ListItem>
                                ))}
                            </List>
                        </Box>
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