import * as React from 'react';
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Checkbox from '@mui/material/Checkbox';
import {Button, Fab, Stack} from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import Typography from "@mui/material/Typography";
import {useEffect, useState} from "react";
import {trialsCreate} from "../stores/TrialCreationStore";

function CreateTrial()
{
    const [checked, setChecked] = React.useState([0]);
    const [trialName, setTrialName] = useState("");
    const [companyName, setCompanyName] = useState("");

    function handleSubmit(e) {
        console.log("Clicked")
    }


    const handleToggle = (value) => () => {
        const currentIndex = checked.indexOf(value);
        const newChecked = [...checked];

        if (currentIndex === -1) {
            newChecked.push(value);
        } else {
            newChecked.splice(currentIndex, 1);
        }

        setChecked(newChecked);
    };

    return(
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
                                value={trialName}
                                label="Trial name"
                                defaultValue=""
                            />
                            <TextField
                                required
                                id="outlined-required"
                                value={companyName}
                                label="Company or origination"
                                defaultValue=""
                            />
                            <Button onClick={handleSubmit}>
                                Submit
                            </Button>
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

                            <List>
                                <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
                                    {[0, 1, 2, 3, 4].map((value) => {
                                        const labelId = `checkbox-list-label-${value}`;

                                        return (
                                            <ListItem
                                                key={value}
                                                disablePadding
                                            >
                                                <ListItemButton role={undefined} onClick={handleToggle(value)} dense>
                                                    <ListItemIcon>
                                                        <Checkbox
                                                            edge="start"
                                                            checked={checked.indexOf(value) !== -1}
                                                            tabIndex={-1}
                                                            disableRipple
                                                            inputProps={{ 'aria-labelledby': labelId }}
                                                        />
                                                    </ListItemIcon>
                                                    <ListItemText id={labelId} primary={`Medical specification ${value + 1}`} />
                                                </ListItemButton>
                                            </ListItem>
                                        );
                                    })}
                                </List>
                            </List>
                        </Grid>
                    </Grid>
                </div>

        </div>
    )
}

export default CreateTrial;