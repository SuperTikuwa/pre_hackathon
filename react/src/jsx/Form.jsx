import React from "react"
// import { Button, TextField } from "@material-ui/core"
import Button from "@material-ui/core/Button"
import TextField from "@material-ui/core/TextField"
import Box from "@material-ui/core/Box"
import Container from "@material-ui/core/Container"

class Form extends React.Component {
	constructor(props) {
		super(props)
	}

	render() {
		return (
			<div>
				<Box>
					{/* <Container> */}
					<form>
						<TextField
							id="standard-required"
							label=""
							// fullWidth
							required
							multiline
							valiant="outlined"
							rows="3"
						></TextField>
						{/* <input type="submit" value="登録" /> */}
						<Button color="primary" variant="contained">
							登録
						</Button>
					</form>
					{/* </Container> */}
				</Box>
			</div>
		)
	}
}

export default Form
