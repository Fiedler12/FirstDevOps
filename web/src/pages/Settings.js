import * as React from 'react';

import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import FormGroup from '@mui/material/FormGroup';
import Switch from '@mui/material/Switch';
import {useEffect, useState} from "react";
import {SettingsStore} from "../stores/SettingsStore";
import Button from "@mui/material/Button";
import {tokenstore} from "../stores/TokenStore";


// Taken from: https://github.com/mui/material-ui/tree/v5.10.6/docs/data/material/getting-started/templates/sign-up



const theme = createTheme();

export default function Settings() {

    const [settings, setSettings] = useState([]);

    const store = new SettingsStore();

    useEffect(() => {
      async function getSettings() {
        setSettings(await store.fetchSettings())

      }
      getSettings()
    }, [])

    // const handleSubmit = (event) => {
    //     event.preventDefault();
    //     const data = new FormData(event.currentTarget);
    //     console.log({
    //         email: data.get('email'),
    //         password: data.get('password'),
    //         switch: data.get('switch')
    //     });
    // };
    const handleSubmit = async (event) => {
        event.preventDefault();
        await store.updateSettings(settings)
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline />

                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Typography component="h1" variant="h5">
                        Personlig data
                    </Typography>
                    <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <Grid container spacing={2}>
                            <Grid item xs={12}>
                                <Typography component="h1" variant="h8" fontSize={16}>
                                    Navn
                                </Typography>
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    fullWidth

                                    label={settings.name}
                                    // set name to value
                                    onChange={(e)=> {
                                        setSettings.name = e.target.value
                                    }}


                                />
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    fullWidth

                                    label={settings.lastname}
                                    onChange={(e)=> {
                                        setSettings.lastname = e.target.value
                                    }}

                                />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography component="h1" variant="h8" fontSize={16}>
                                    Email
                                </Typography>
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    fullWidth

                                    label={settings.email}
                                    onChange={(e)=> {
                                        setSettings.email = e.target.value
                                    }}

                                />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography component="h1" variant="h8" fontSize={16}>
                                    CPR-Nummer
                                </Typography>
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    fullWidth

                                    label={settings.cpr}
                                    onChange={(e)=> {
                                        setSettings.cpr = e.target.value
                                    }}

                                />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography component="h1" variant="h8" fontSize={16}>
                                    Sygdomme
                                </Typography>
                            </Grid>
                            <Grid item xs={12}>
                                <TextField

                                    fullWidth

                                    label="Ringorm, fodvorter, festryger"


                                />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography component="h1" variant="h8" fontSize={16}>
                                    Blodtype
                                </Typography>
                            </Grid>
                            <Grid item xs={12}>
                                <TextField

                                    fullWidth

                                    label="A Rhesus positiv"


                                />
                            </Grid>

                            <Grid item xs={12}>
                                <FormGroup>
                                <FormControlLabel control={<Switch />} label="Editable"
                                id = "switch"/>
                                </FormGroup>
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="contained"
                                    sx={{mt: 3, mb: 2}}
                                >
                                    Submit
                                </Button>
                            </Grid>
                        </Grid>
                    </Box>
                </Box>

            </Container>
        </ThemeProvider>
    );

}
