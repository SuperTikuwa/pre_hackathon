import React from "react"
import { Container } from "@material-ui/core"
import Form from "./Form"
import Task from "./Task"
import Header from "./Header"
import Test from "./Test"
import axios from "axios"

import Table from "@material-ui/core/Table"
import TableHead from "@material-ui/core/TableHead"
import TableRow from "@material-ui/core/TableRow"
import TableCell from "@material-ui/core/TableCell"
import TableBody from "@material-ui/core/TableBody"

class App extends React.Component {
	constructor(props) {
		super(props)
	}

	date = new Date()
	date =
		this.date.getFullYear().toString() +
		"年" +
		this.date.getMonth().toString() +
		"月" +
		this.date.getDay().toString() +
		"日" +
		this.date.getHours().toString() +
		"時" +
		this.date.getMinutes().toString() +
		"分"

	getData() {
		let d = []
		axios
			.get("https://www.googleapis.com/books/v1/volumes?q=react")
			.then((r) => {
				r.data.items.map((m) => {
					d.push({ detail: m.volumeInfo.title, deadline: this.date })
				})
			})
		// console.log(d)
		return d
	}

	taskID = 0

	render() {
		let data = this.getData()
		console.log(data)
		console.log(data.length)
		console.log(data)

		data.forEach((element) => {
			console.log(element)
		})
		data.map((e) => console.log(e))
		return (
			<div>
				<Header />
				{/* <Test /> */}
				<Container maxWidth="sm">
					<h1>タスクを登録してください</h1>
					<Form component="h2" variant="h5"></Form>
					<Table>
						<TableHead>
							<TableRow>
								<TableCell align="right">Detail</TableCell>
								<TableCell align="right">Deadline</TableCell>
								<TableCell align="right">RegisteredTime</TableCell>
								<TableCell align="right">Delete</TableCell>
							</TableRow>
						</TableHead>
						<TableBody>
							{data.map((e) => {
								console.log(e)
								return (
									<Task
										detail={e.detail}
										deadline={e.deadline}
										key={this.taskID++}
									/>
								)
							})}
						</TableBody>
					</Table>
				</Container>
			</div>
		)
	}
}

export default App
