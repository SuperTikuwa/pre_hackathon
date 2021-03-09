import React from "react"
import Card from "@material-ui/core/Card"
import Typography from "@material-ui/core/Typography"
import CardContent from "@material-ui/core/CardContent"
import Button from "@material-ui/core/Button"
import TableRow from "@material-ui/core/TableRow"
import TableCell from "@material-ui/core/TableCell"

import "fontsource-roboto"

class Task extends React.Component {
	detail = ""
	deadline = ""

	constructor(props) {
		super(props)
		this.detail = props.detail
		this.deadline = props.deadline
	}

	render() {
		return (
			<TableRow>
				<TableCell align="right">{this.detail}</TableCell>
				<TableCell align="right">{this.deadline}</TableCell>
				<TableCell align="right">{this.deadline}</TableCell>
				<TableCell align="right">
					<Button color="secondary" variant="contained">
						削除
					</Button>
				</TableCell>
			</TableRow>
		)
	}
}

export default Task
