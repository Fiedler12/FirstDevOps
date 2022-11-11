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
    const [settings, setSettings] = useState({
        id: 0,
        name: '',
        email: '',
        password: '',
        cpr: ''
    });
    let [name, setName] = useState(settings.name)
    const [email, setEmail] = useState(settings.email)
    const [cpr, setCpr] = useState(settings.cpr)
    const store = new SettingsStore()

    useEffect(() => {
      async function getSettings() {
          setSettings(await store.fetchSettings())
      }
        getSettings()
        setInfo()
    }, [])

    function setInfo() {
        setName(settings.name)
        setEmail(settings.email)
        setCpr(settings.cpr)
    }

    async function clickHandler() {
        let newSettings = {
            id: settings.id,
            name: name,
            email: email,
            password: settings.password,
            cpr: cpr
        }
        await setSettings(newSettings)
        store.updateSettings(newSettings)
    }


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
                    <Box sx={{ mt: 3 }}>
                        <Grid container spacing={2}>
                            <Grid item xs={12}>
                                <Typography component="h1" variant="h8" fontSize={16}>
                                    Navn
                                </Typography>
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    fullWidth
                                    label={'Name'}
                                    value={name}
                                    onChange={(e) => {
                                        setName(e.target.value)
                                    }}
                                />
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    fullWidth
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
                                    defaultValue={settings.email}
                                    onChange={(e) => {
                                        setEmail(e.target.value)
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
                                    defaultValue={settings.cpr}
                                    onChange={(e) => {
                                        setCpr(parseInt(e.target.value))
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
                                <Switch />
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="contained"
                                    sx={{mt: 3, mb: 2}} onClick={clickHandler}>
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
