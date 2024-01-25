import React, {useEffect, useState} from 'react';
import axios from 'axios';

const BoardList = () => {
    const [boardList, setBoardList] = useState([]);
    
    const getBoardList = async () => {
        const resp = (await axios.get('//localhost:8080/api/v1/data')).data
        setBoardList(resp);

    }

    useEffect(() => {
        getBoardList();
    }, []);

    return (
        <div>
            <ul>
                {boardList.map((board) => (
                    <li key={board.testId}>{board.cnt}</li>
                ))}
            </ul>
        </div>
    );
};

export default BoardList;
