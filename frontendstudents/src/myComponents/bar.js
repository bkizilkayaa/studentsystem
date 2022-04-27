import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import { Menu as MenuIcon } from "@material-ui/icons";

function ButtonAppBar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" color="success">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h5" component="div" color="white" sx={{ flexGrow: 1 }}>
            my first fullstack app with using spring boot/react
          </Typography>
          <a color="inherit"> Burak Kizilkaya </a> 
        </Toolbar>
      </AppBar>
    </Box>
  );
}
export default ButtonAppBar