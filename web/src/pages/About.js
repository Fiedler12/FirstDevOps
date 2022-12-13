import {Grid, Typography} from "@mui/material";

function About() {
    return(
        <Grid
            container
            spacing={0}
            rowSpacing={2}
            direction="column"
            alignItems="center"
            justifyContent="center"
            style={{ minHeight: '40vh' }}>
            <Typography variant={"h2"}>
                This is the about page, nothing interesting to see here.
                Some more text
            </Typography>
        </Grid>
    )

}

export default About;